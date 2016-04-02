import org.openqa.selenium.firefox.FirefoxDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.phantomjs.PhantomJSDriver
import org.openqa.selenium.remote.DesiredCapabilities
import org.openqa.selenium.remote.RemoteWebDriver
import org.openqa.selenium.Dimension

baseUrl = "http://decohere.herokuapp.com"

environments {
  chrome {
    driver = { new ChromeDriver() }
  }

  firefox {
    driver = { new FirefoxDriver() }
  }

  phantomJs {
    driver = {
      def driver = new PhantomJSDriver(new DesiredCapabilities())
      driver.manage().window().setSize(new Dimension(1600, 1200))
      driver
    }
  }

  remote {
    driver = {
      DesiredCapabilities capabilities = DesiredCapabilities.firefox()
      capabilities.setCapability("version", "17")
      capabilities.setCapability("platform", "Windows 2012")
      new RemoteWebDriver(
        new URL("http://:<access_key>@ondemand.saucelabs.com:80/wd/hub"), capabilities
      )
    }
  }
}

reportsDir = new File("target/geb-reports")
reportOnTestFailureOnly = true
