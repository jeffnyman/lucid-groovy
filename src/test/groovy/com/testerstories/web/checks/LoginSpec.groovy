package com.testerstories.web.checks

import com.testerstories.web.pages.DecoherePage
import com.testerstories.web.pages.HomePage

import geb.spock.GebReportingSpec
import spock.lang.Stepwise

@Stepwise
class LoginSpec extends GebReportingSpec {
  def "valid user logs in"() {
    given: 'the decohere page'
      to DecoherePage

    when: 'using a valid login'
      loginForm.click()
      username = "admin@decohere.com"
      password = "admin"
      login.click()

    then: 'home page is displayed with success message'
      at HomePage
      message == "You are now logged in as admin@decohere.com."
  }

  def "invalid logins are prevented"() {
    given: 'the decohere page'
      to DecoherePage

    when: 'using an invalid login'
      loginForm.click()
      username = "admin@decohere.com"
      password = "testing"
      login.click()

    then: 'user is provided invalid login message'
      at DecoherePage
      error == "Unable to login as admin@decohere.com."
  }
}
