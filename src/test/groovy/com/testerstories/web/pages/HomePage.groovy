package com.testerstories.web.pages

import geb.Page

class HomePage extends Page {
  static url = "/home"
  static at = { title == "Decohere - Home" }

  static content = {
    message { $(".notice").text() }
  }
}
