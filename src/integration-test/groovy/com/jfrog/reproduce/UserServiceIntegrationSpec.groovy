package com.jfrog.reproduce

import grails.test.mixin.integration.Integration
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.core.io.ClassPathResource
import org.springframework.core.io.Resource
import spock.lang.Specification

/**
 * Created by shiranr on 29/03/2016.
 */
@Integration
class UserServiceIntegrationSpec extends Specification {

    @Autowired
    UserService userService

    void "test something"() {
        setup:
        User user = userService.createUser()
        user.username = 'another'
        user.save(flush: true)
        user.refresh()

        when:
        userService.createProfile(user)

        then:
        Profile.findAllByOwner(user)
        user.findProfile()
    }
}
