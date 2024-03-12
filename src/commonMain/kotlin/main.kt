
import korlibs.event.Key
import korlibs.image.color.Colors
import korlibs.korge.Korge
import korlibs.korge.input.keys
import korlibs.korge.scene.Scene
import korlibs.korge.scene.sceneContainer
import korlibs.korge.view.SContainer
import korlibs.korge.view.addUpdater
import korlibs.korge.view.align.centerOnStage
import korlibs.korge.view.collision.collidesWith
import korlibs.korge.view.position
import korlibs.korge.view.solidRect
import korlibs.math.geom.Size

suspend fun main() = Korge(
    windowSize = Size(1920, 1080),
    backgroundColor = Colors["#2b2b2b"]
) {
    sceneContainer {
        changeTo { InGameScene() }
    }
}

class InGameScene : Scene() {

    private var canMove: Boolean = true

    override suspend fun SContainer.sceneMain() {
        val beerDrinker = solidRect(width = 64, height = 64) {
            color = Colors.CORNFLOWERBLUE
            centerOnStage()
        }

        keys {
            down {
                if (canMove) {
                    when (it.key) {
                        Key.LEFT -> beerDrinker.x -= MOVE_SPEED
                        Key.RIGHT -> beerDrinker.x += MOVE_SPEED
                        Key.UP -> beerDrinker.y -= MOVE_SPEED
                        Key.DOWN -> beerDrinker.y += MOVE_SPEED
                        else -> Unit
                    }
                }
            }
        }
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

        beerDrinker.addUpdater {
            canMove = true

            if (beerDrinker.collidesWith(listOf(leftSide, upSide, rightSide, bottomLeft, bottomRight))) {
                canMove = false
            }
        }
    }

    companion object {
        private const val MOVE_SPEED = 30
    }
}
