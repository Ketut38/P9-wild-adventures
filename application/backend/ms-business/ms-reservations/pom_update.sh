
MAVEN_BIN=`which mvn`

UPDATE_DEPENDENCIES_WITH_GROUPID="com.wildadventures*:*"

MAVEN_VERSIONS_PLUGIN="org.codehaus.mojo:versions-maven-plugin:1.3.1"
MAVEN_VERSIONS_PLUGIN_SET_GOAL="${MAVEN_VERSIONS_PLUGIN}:set -DgenerateBackupPoms=false"
MAVEN_HELP_PLUGIN_EVALUATE_VERSION="mvn help:evaluate -Dexpression=project.version -q -DforceStdout"


function validatePomExists() {
  CURRENT_DIRECTORY=`pwd`
  if [ -f pom.xml ] ; then
    echo -e "Found pom.xml file: [\e[32m${PWD##*/}\e[0m/pom.xml]"
  else
    echo "ERROR: No pom.xml file detected in current directory [${CURRENT_DIRECTORY}]. Exiting script with error status."
    exit 50
  fi
}

function updateProjectPomsToNextVersion() {

  CURRENT_PROJECT_VERSION=`${MAVEN_HELP_PLUGIN_EVALUATE_VERSION}`
  echo -e "Updating \e[32m${PWD##*/}\e[0m version from \e[91m[${CURRENT_PROJECT_VERSION}]\e[0m to \e[32m[${projectVersion}]\e[0m..."
  
  ${MAVEN_BIN} ${MAVEN_VERSIONS_PLUGIN_SET_GOAL} -DnewVersion="${projectVersion}-SNAPSHOT" -DgenerateBackupPoms=false
}

#################################################################################
# Update the project POMs with the new build number.
#################################################################################

validatePomExists

updateProjectPomsToNextVersion


