package com.testerstories.web.pages

import geb.Page

class DecoherePage extends Page {
  static url = "/"
  static at = { title == "Decohere" }

  static content = {
    message { $(".notice").text() }
    error { $(".error").text() }

    loginForm { $("#openLogin" ) }
    username { $("#username") }
    password { $("#password") }
    login { $("#login") }

    loginAsAdmin {
      loginForm.click()
      username = "admin@decohere.com"
      password = "admin"
      login.click()
    }
  }
}
