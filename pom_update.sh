
MAVEN_BIN=`which mvn`

UPDATE_DEPENDENCIES_WITH_GROUPID="com.wildadventures*:*"

MAVEN_VERSIONS_PLUGIN="org.codehaus.mojo:versions-maven-plugin:1.3.1"
MAVEN_VERSIONS_PLUGIN_SET_GOAL="${MAVEN_VERSIONS_PLUGIN}:set -DgenerateBackupPoms=false"
MAVEN_VERSIONS_PLUGIN_UPDATE_PARENT_GOAL="${MAVEN_VERSIONS_PLUGIN}:update-parent -DgenerateBackupPoms=false -DallowSnapshots=true"
MAVEN_VERSIONS_PLUGIN_UPDATE_DEPENDENCIES_GOAL="${MAVEN_VERSIONS_PLUGIN}:use-latest-versions -DgenerateBackupPoms=false -DallowSnapshots=false"

function validatePomExists() {
  CURRENT_DIRECTORY=`pwd`
  if [ -f pom.xml ] ; then
    echo "Found pom.xml file: [${CURRENT_DIRECTORY}/pom.xml]"
  else
    echo "ERROR: No pom.xml file detected in current directory [${CURRENT_DIRECTORY}]. Exiting script with error status."
    exit 50
  fi
}


function updateProjectPomsToNextVersion() {

echo Choose new pom version for com.wildadventures
read -p 'New project version: ' projectVersion


  echo "Updating project version to [${projectVersion}]..."
  ${MAVEN_BIN} ${MAVEN_VERSIONS_PLUGIN_SET_GOAL} -DnewVersion=${projectVersion}
}

#################################################################################
# Update the project POMs with the new build number.
#################################################################################

validatePomExists

updateProjectPomsToNextVersion


