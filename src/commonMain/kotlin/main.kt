
import korlibs.event.Key
import korlibs.image.color.Colors
import korlibs.korge.Korge
import korlibs.korge.input.keys
import korlibs.korge.scene.Scene
import korlibs.korge.scene.sceneContainer
import korlibs.korge.view.SContainer
import korlibs.korge.view.align.centerOnStage
import korlibs.korge.view.solidRect
import korlibs.math.geom.Size

suspend fun main() = Korge(
    windowSize = Size(1920, 1080),
    backgroundColor = Colors["#2b2b2b"]
) {
    sceneContainer {
        changeTo { BarScene() }
    }
}

class InGameScene : Scene() {

    override suspend fun SContainer.sceneMain() {
        val beerDrinker = solidRect(width = 64, height = 64) {
            color = Colors.CORNFLOWERBLUE
            centerOnStage()
        }

        keys {
            down {
                when (it.key) {
                    Key.LEFT -> beerDrinker.x -= 10
                    Key.RIGHT -> beerDrinker.x += 10
                    Key.UP -> beerDrinker.y -= 10
                    Key.DOWN -> beerDrinker.y += 10
                    else -> Unit
                }
            }
        }
    }
}
