#!/bin/bash

while [ "$1" != '' ]
  do


    
    
    [ "$1" == "-cf_u" ] && CF_USER=$2 && shift; shift;
    [ "$1" == "-cf_p" ] && CF_PASS=$2 && shift; shift;
    
    [ "$1" == "-br_u" ] && BR_USER=$2 && shift; shift;
    [ "$1" == "-br_p" ] && BR_PASS=$2 && shift; shift;

    [ "$1" == "-cf_api" ] && CF_API=$2 && shift; shift;

    [ "$1" == "-br_name" ] && BR_NAME=$2 && shift; shift;
    [ "$1" == "-br_url" ] && BR_URL=$2 && shift; shift;





done

if [ "$CF_USER" != '' ] && [ "$CF_PASS" != '' ] && [ "$CF_API" != '' ] && [ "$BR_USER" != '' ] && ["$BR_PASS" != '' ] && ["$BR_NAME" != '' ] && [ "$BR_URL" != '' ]; then
  echo "all clear"
else
  echo "PARAMS: -cf_u CF USER 
  -cf_p CF_PASS 
  -cf_api CF API 
  -br_u broker user 
  -br_p broker pass 
  -br_name broker name 
  -br_url broker url" && shift;
fi


#cf login -a  $CF_API:443 --skip-ssl-validation -u $CF_USER -p $CF_PASS --skip-ssl-validation

#cf update-service-broker $BR_NAME $BR_USER $BR_PASS https://$BR_URL
#cf enable-service-access $BR_NAME


