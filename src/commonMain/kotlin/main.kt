
import korlibs.event.Key
import korlibs.image.color.Colors
import korlibs.image.text.RichTextData
import korlibs.korge.Korge
import korlibs.korge.input.keys
import korlibs.korge.scene.Scene
import korlibs.korge.scene.sceneContainer
import korlibs.korge.view.*
import korlibs.korge.view.collision.collidesWith
import korlibs.math.geom.Size

suspend fun main() = Korge(
    windowSize = Size(1000, 600),
    backgroundColor = Colors["#2b2b2b"]
) {
    sceneContainer {
        changeTo { InGameScene() }
    }
}

class InGameScene : Scene() {

    private var canMove: Boolean = true
    private var playerX: Double = 0.0
    private var playerY: Double = 0.0

    override suspend fun SContainer.sceneMain() {
        val beerDrinker = solidRect(width = 64, height = 64) {
            color = Colors.CORNFLOWERBLUE
            position(x = 600, y = 250)
        }

        val left = solidRect(width = WALL_THICKNESS, height = 500) {
            color = Colors.AQUA
            position(x = 10, y = 0)
        }
        val top = solidRect(width = 500, height = WALL_THICKNESS) {
            color = Colors.AQUA
            position(x = 10, y = 0)
        }
        val right = solidRect(width = WALL_THICKNESS, height = 500) {
            color = Colors.AQUA
            position(x = 500, y = 0)
        }
        val bottom = solidRect(width = 240, height = WALL_THICKNESS) {
            color = Colors.AQUA
            position(x = 10, y = 500)
        }

        val walls = listOf(left, top, right, bottom)
        var previousPositionX = 0.0
        var previousPositionY = 0.0

        keys {
            down {
                when (it.key) {
                    Key.LEFT -> {
                        previousPositionX = beerDrinker.x
                        beerDrinker.x -= MOVE_SPEED
                    }
                    Key.RIGHT -> {
                        previousPositionX = beerDrinker.x
                        beerDrinker.x += MOVE_SPEED
                    }
                    Key.UP -> {
                        previousPositionY = beerDrinker.y
                        beerDrinker.y -= MOVE_SPEED
                    }
                    Key.DOWN -> {
                        previousPositionY = beerDrinker.y
                        beerDrinker.y += MOVE_SPEED
                    }
                    else -> Unit
                }
            }
        }

        addUpdater {
            if (beerDrinker.collidesWith(walls)) {
                beerDrinker.x = previousPositionX
                beerDrinker.y = previousPositionY
            }
        }

        textBlock {
            position(x = 1500, y = 100)
        }.addUpdater {
            text = RichTextData(text = "x: $playerX, y: $playerY")
        }
    }

    companion object {
        private const val MOVE_SPEED = 5f
        private const val WALL_THICKNESS = 20
    }
}
