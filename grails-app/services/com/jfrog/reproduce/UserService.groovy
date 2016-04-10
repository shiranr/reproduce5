package com.jfrog.reproduce

import grails.transaction.Transactional

@Transactional
class UserService {

    def serviceMethod() {

    }

    def createProfile(User user) {
        Profile profile= new Profile()
        profile.setOwner(user)
        profile.setName('name')
        profile.save(flush:true, failOnError: true)
    }

    User createUser() {
        User user = new User()
        user.username = 'username'
        user.save(flush: true, failOnError: true)
    }
}
