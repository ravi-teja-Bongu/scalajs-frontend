import org.scalajs.dom.{Fetch, console}
import slinky.core.Component
import slinky.core.annotations.react
import slinky.core.facade.ReactElement
import slinky.web.html
import slinky.web.html.{`type`, button, div, h1, h2, img, onClick, p, src, style}
import scala.concurrent.Future
import scala.concurrent.ExecutionContext.Implicits.global
import scala.scalajs.js
import scala.scalajs.js.Thenable.Implicits.thenable2future
@react class FetchingComponent extends Component {
  type Props = Unit
  type State = String
  override def initialState: String = ""

  def render(): ReactElement = {
    div(
      style := js.Dynamic.literal(
        backgroundColor = "#f0f8ff",
        padding = "20px",
        borderRadius = "10px",
        textAlign = "center",
        maxWidth = "600px",
        margin = "20px auto",
        position = "relative"
      ),
      // Container for the top navigation buttons
      div(
        style := js.Dynamic.literal(
          display = "flex",
          justifyContent = "flex-end",
          gap = "10px",
          marginBottom = "20px"
        ),
        button(
          style := js.Dynamic.literal(
            padding = "10px 20px",
            backgroundColor = "#4CAF50",
            color = "white",
            border = "none",
            borderRadius = "25px",
            cursor = "pointer",
            width = "fit-content",
            height ="fit-content"
          )
        )("Home"),
        button(
          style := js.Dynamic.literal(
            padding = "10px 20px",
            backgroundColor = "#4CAF50",
            color = "white",
            border = "none",
            borderRadius = "25px",
            cursor = "pointer",
            width = "fit-content",
            height = "fit-content"
          )
        )("About Us"),
        button(
          style := js.Dynamic.literal(
            padding = "10px 20px",
            backgroundColor = "#4CAF50",
            color = "white",
            border = "none",
            borderRadius = "25px",
            cursor = "pointer",
            width = "fit-content",
            height = "fit-content"
          )
        )("What We Do"),
        button(
          style := js.Dynamic.literal(
            padding = "10px 20px",
            backgroundColor = "#4CAF50",
            color = "white",
            border = "none",
            borderRadius = "25px",
            cursor = "pointer",
            width = "fit-content",
            height = "fit-content"
          )
        )("Products"),
        button(
          style := js.Dynamic.literal(
            padding = "10px 20px",
            backgroundColor = "#4CAF50",
            color = "white",
            border = "none",
            borderRadius = "25px",
            cursor = "pointer",
            width = "fit-content",
            height = "fit-content"
          )
        )("Blogs"),
        button(
          style := js.Dynamic.literal(
            padding = "10px 20px",
            backgroundColor = "#4CAF50",
            color = "white",
            border = "none",
            borderRadius = "25px",
            cursor = "pointer",
            width = "fit-content",
            height = "fit-content"
          )
        )("Contact Us")
      ),
      button(
        `type` := "Button",
        style := js.Dynamic.literal(
          padding = "10px 20px",
          backgroundColor = "#4CAF50",
          color = "white",
          border = "none",
          borderRadius = "5px",
          cursor = "pointer"
        ),
        html.onClick := (e => Fetch.fetch("http://localhost:9000/api/data") // Fetching data from Play Framework backend
          .flatMap { response =>
            println(s"${response.statusText}")
            if (response.ok) {
              response.text().toFuture.foreach { s => setState(s) }
              response.text().toFuture.map(Some(_))
            } else {
              console.error(s"Failed to fetch data: ${response.statusText}")
              response.text().toFuture.foreach(s => println(s))
              Future.successful(None)
            }
          }
          )
      )("Fetch Data"),
      h1("Codinoverse Private Limited"),
      img(
        src := "https://media.licdn.com/dms/image/D560BAQE1jAdRvacE2Q/company-logo_200_200/0/1710177415044/codinoverse_logo?e=2147483647&v=beta&t=MgU8TwBLRt926anYTxGMaGHdfoA38vgSgdcjmP-TPxg",
        style := js.Dynamic.literal(
          margin = "20px 0",
          borderRadius = "10px"
        )
      ),
      h2("Simplifying Software, Amplifying Success"),
      div(
        style := js.Dynamic.literal(
          display = "flex",
          justifyContent = "center",
          gap = "10px",
          marginTop = "20px"
        ),
        button(
          style := js.Dynamic.literal(
            padding = "10px 20px",
            backgroundColor = "#4CAF50",
            color = "white",
            border = "none",
            borderRadius = "5px",
            marginLeft = "10px",
            cursor = "pointer"
          )
        )("Signup"),
        button(
          style := js.Dynamic.literal(
            padding = "10px 20px",
            backgroundColor = "#4CAF50",
            color = "white",
            border = "none",
            borderRadius = "5px",
            cursor = "pointer"
          )
        )("Email ID"),
        button(
          style := js.Dynamic.literal(
            padding = "10px 20px",
            backgroundColor = "#4CAF50",
            color = "white",
            border = "none",
            borderRadius = "5px",
            marginRight = "10px",
            cursor = "pointer"
          )
        )("Info")
      ),
      p(
        style := js.Dynamic.literal(
          fontSize = "18px",
          color = "#333"
        )
      )(state)
    )
  }
}


