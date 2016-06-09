package mappings

import models.{Enquete, ValorSensor}
import spray.json.DefaultJsonProtocol

trait JsonMappings extends DefaultJsonProtocol {

  case class EnqueteResposta(enquete: Enquete, respostas: List[Resposta])

  implicit val usuarioRespostaFormat = jsonFormat2(ValorSensor)
  implicit val respostaFormat = jsonFormat3(Resposta)
  implicit val enqueteFormat = jsonFormat3(Enquete)
  implicit val enqueteRepostaFormat = jsonFormat2(EnqueteResposta)
}