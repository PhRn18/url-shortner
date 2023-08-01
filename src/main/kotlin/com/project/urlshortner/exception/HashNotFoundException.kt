package com.project.urlshortner.exception

class HashNotFoundException(hash:String):RuntimeException("$hash not found")