/**
 *  Copyright 2024 Raziq York
 *
 *	Author: Raziq York, Based on original work by Stuart Buchanan + Ian M with thanks
 *	Date: 2024-11-11 v1.0 Initial Release
 */
 
import groovy.json.JsonOutput
import groovy.json.JsonSlurper
import java.util.Random  

preferences {
}  
 
metadata {
	definition (name: "Tado Home/Away Mode", namespace: "fuzzysb", author: "Stuart Buchanan") {
		capability "Switch"
        attribute "tadoMode", "string"
	}

	// simulator metadata
	simulator {
		// status messages
		// reply messages
	}
}

def installed() {
	log.debug "Executing 'installed'"
	sendEvent(name: "tadoMode", value: "HOME")
}

def on() {
	log.trace "Executing 'on'"
	parent.setPresence("HOME")
    def result = sendEvent(name: "tadoMode", value: "HOME")
    return result
}

def off() {
	log.trace "Executing 'off'"
	parent.setPresence("AWAY")
    def result = sendEvent(name: "tadoMode", value: "AWAY")
    return result
}
