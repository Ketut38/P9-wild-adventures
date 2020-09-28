


MAVEN_BIN=`which mvn`

UPDATE_DEPENDENCIES_WITH_GROUPID="com.wildadventures*:*"

MAVEN_VERSIONS_PLUGIN="org.codehaus.mojo:versions-maven-plugin:1.3.1"
MAVEN_VERSIONS_PLUGIN_SET_GOAL="${MAVEN_VERSIONS_PLUGIN}:set -DgenerateBackupPoms=false"
MAVEN_VERSIONS_PLUGIN_UPDATE_PARENT_GOAL="${MAVEN_VERSIONS_PLUGIN}:update-parent -DgenerateBackupPoms=false -DallowSnapshots=true"
MAVEN_VERSIONS_PLUGIN_UPDATE_DEPENDENCIES_GOAL="${MAVEN_VERSIONS_PLUGIN}:use-latest-versions -DgenerateBackupPoms=false -DallowSnapshots=false"

MAVEN_HELP_PLUGIN="mvn org.apache.maven.plugins:maven-help-plugin:2.2"
MAVEN_HELP_PLUGIN_EVALUATE_VERSION_GOAL="mvn org.apache.maven.plugins:maven-help-plugin:2.2:evaluate -Dexpression=project.version"
MAVEN_HELP_PLUGIN_EVALUATE_ARTIFACT_ID="mvn help:evaluate -Dexpression=project.artifactId -q -DforceStdout"
MAVEN_HELP_PLUGIN_EVALUATE_VERSION="mvn help:evaluate -Dexpression=project.version -q -DforceStdout"

function validatePom() {
  ${MAVEN_BIN} validate
  STATUS=`echo $?`
  if [ ${STATUS} -ne 0 ] ; then
    echo "ERROR: Maven POM did not validate successfully. Exiting script with error status."
    exit 40
  fi
}

function initCurrentProjectVersion() {

  echo -e  "Detecting current project version number for \e[32m${PWD##*/}\e[0m..."

  CURRENT_PROJECT_VERSION=`${MAVEN_HELP_PLUGIN_EVALUATE_VERSION}`
  
   echo -e  "Version found: \e[91m[${CURRENT_PROJECT_VERSION}]\e[0m"
  
}

initCurrentProjectVersion