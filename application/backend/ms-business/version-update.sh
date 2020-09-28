
echo -e "\n";
for i in {240..254} {254..256}; do echo -e -n "\e[38;5;${i}m#\e[0m"; done ; echo -en "\e[1;96mUPDATE POM VERSION TOOL\e[0m"; for j in {256..254} {254..240} ; do echo -en "\e[38;5;${j}m#\e[0m"; done ; 
echo -e "\n";

function navigateD() {

  (cd ms-adventures/ ; sh project_version.sh)
  
  
   echo -e   "Please \e[5mset \e[25ma new version number for \e[1mcom.wildadventures\e[0m";
   
   read -p 'new version number: ' projectVersion
   export projectVersion
   echo -e "\n";
   echo -e "\e[1mUpdating pom for\e[0m \e[32mms-adventures\e[0m";
  (cd ms-adventures/ ; sh pom_update.sh)
  echo -e "\n";
   echo -e "\e[1mUpdating pom for\e[0m \e[32mms-categories\e[0m";

  (cd ms-categories/bin/ ; sh pom_update.sh)
 echo -e "\n";
  echo -e "\e[1mUpdating pom for\e[0m \e[32mms-comments\e[0m";
  
  (cd ms-comments/ ; sh pom_update.sh)
  echo -e "\n";
  echo -e "\e[1mUpdating pom for\e[0m \e[32mms-config-server\e[0m";
 
  (cd ms-config-server/ ; sh pom_update.sh)
  echo -e "\n";
  echo -e "\e[1mUpdating pom for\e[0m \e[32mms-eureka\e[0m";
  
  (cd ms-eureka/ ; sh pom_update.sh)
  echo -e "\n";
  echo -e "\e[1mUpdating pom for\e[0m \e[32mms-payment\e[0m";
  
  (cd ms-payment/ ; sh pom_update.sh)
  echo -e "\n";
  echo -e "\e[1mUpdating pom for\e[0m \e[32mms-reservations\e[0m";
  
  (cd ms-reservations/ ; sh pom_update.sh)
  echo -e "\n";
  echo -e "\e[1mUpdating pom for\e[0m \e[32mms-session\e[0m";
  
  (cd ms-session/ ; sh pom_update.sh)
  echo -e "\n";
  echo -e "\e[1mUpdating pom for\e[0m \e[32mms-users\e[0m";
  
  (cd ms-users/ ; sh pom_update.sh)
  echo -e "\n";
for i in {240..254} {254..256}; do echo -e -n "\e[38;5;${i}m#\e[0m"; done ; echo -en "\e[1;92mDONE\e[0m"; for j in {256..254} {254..240} ; do echo -en "\e[38;5;${j}m#\e[0m"; done ; 
echo -e "\n";

$SHELL
  
}

navigateD

$SHELL