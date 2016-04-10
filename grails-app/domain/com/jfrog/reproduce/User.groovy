package com.jfrog.reproduce

class User {

    String username

    Profile findProfile() {
        Profile.createCriteria().list {
            eq('owner', this)
        }
    }
}
