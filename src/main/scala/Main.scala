import org.scalajs.dom
import org.scalajs.dom.document
import scalajs.js
import slinky.web.ReactDOM
import slinky.web.html._
object Main {
  def main(args: Array[String]): Unit = {
    ReactDOM.render(
      div(
        style := js.Dynamic.literal(
          backgroundColor = "#f0f8ff",
          padding = "20px",
          borderRadius = "10px",
          textAlign = "center",
          maxWidth = "1400px",
          margin = "20px auto"
        ),
        h1("Welcome :)"), FetchingComponent("stug")),
      //(div(h1("raviplay"),FetchingComponent("stug"))),
      document.getElementById("react-root")
    )
  }
}