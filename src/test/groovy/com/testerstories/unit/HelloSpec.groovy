package com.testerstories.unit

import spock.lang.Specification

class HelloJeff extends Specification {
  def hello = new Hello()

  def sayHello() {
    given: "a name provided"
    def greeting = hello.sayHello("Casey")

    expect: "greeting uses that name"
    greeting == "Hello Casey"
  }
}
