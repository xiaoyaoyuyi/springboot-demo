#!/usr/bin/env bash

set -o nounset
set -o errexit

function init() {
	home_path="${HOME}";
	jar_package_name="demo";
	jar_package_path="${home_path}/code/springboot_demo/demo/target";
	jacoco_http_port=32152
	jacoco_http_address="127.0.0.1"
	version="0.0.1"
	project_dir="${home_path}/qa/jars"

	if [ $? -gt 0 ]; then
		action=$1
	else
		action=""
	fi

	ps -ef | grep "${jar_package_name}.jar" | grep -v "grep" | awk '{print $2}' | xargs -I {} bash -c 'if [ -n {} ]; then sudo kill -9 {}; fi'
	cd ${home_path}/code/springboot_demo/demo;
}

function package() {
	$(which mvn) clean package -Dmaven.test.skip=true
}

function restart() {
	cp -f "${jar_package_path}/${jar_package_name}-${version}-SNAPSHOT.jar" "${project_dir}"
	unzip -o "${project_dir}/${jar_package_name}-${version}-SNAPSHOT.jar" -d "${project_dir}/${jar_package_name}"
	ps -ef | grep "${jar_package_name}-${version}-SNAPSHOT.jar" | grep -v "grep" | xargs kill -9 || true
	echo -n "进程ID："
	ps -ef | grep -v "grep" | grep 'server.port=9090' | awk '{print $2}'
	java -javaagent:"${home_path}/jacoco-code-coverage/static/thirdlibs/jacocoagent.jar=output=tcpserver,port=${jacoco_http_port},address=${jacoco_http_address}" -Dserver.port=39090 -jar ${project_dir}/${jar_package_name}-${version}-SNAPSHOT.jar 
}

init
if [ ${action} = "package" ]; then
	package;
elif [ ${action} = "restart" ]; then
	restart;
else
	package;
	restart;
fi
