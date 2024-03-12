import korlibs.image.color.Colors
import korlibs.korge.scene.Scene
import korlibs.korge.view.SContainer
import korlibs.korge.view.align.centerOnStage
import korlibs.korge.view.position
import korlibs.korge.view.solidRect

class BarScene: Scene() {

    override suspend fun SContainer.sceneMain() {
        val leftSide = solidRect(width = 10, height = 500) {
            color = Colors.AQUA
            position(x = 10, y = 0)
        }
        val upSide = solidRect(width = 500, height = 10) {
            color = Colors.AQUA
            position(x = 10, y = 0)
        }
        val rightSide = solidRect(width = 10, height = 500) {
            color = Colors.AQUA
            position(x = 500, y = 0)
        }
        val bottomLeft = solidRect(width = 240, height = 10) {
            color = Colors.AQUA
            position(x = 10, y = 500)
        }
        val bottomRight = solidRect(width = 200, height = 10) {
            color = Colors.AQUA
            position(x = 60, y = 500)
        }

    }
}