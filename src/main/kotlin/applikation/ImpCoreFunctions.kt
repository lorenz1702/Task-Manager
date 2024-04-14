package applikation

import domain.*

class ImpCoreFunctions:CoreFunctions {
    val game = GameLogic(ImpWordRepository(),ImpDataRepository(),ImpUserRepository())
    var NumberOfUsers :Int = 0
    var NumberOfSpies :Int = 0

    override fun NumberOfUsers(UserNumber: Int) {
        this.NumberOfUsers = UserNumber
    }

    override fun NumberOfSpys(SpyNumber: Int) {
        if (this.NumberOfUsers <= SpyNumber) {
            throw IllegalArgumentException("SpyNumber is not greater than the Number of Users or the User Number is not set")
        } else {
            this.NumberOfSpies = SpyNumber
        }
    }

    override fun StartGame() {

        this.game.initializeGame(this.NumberOfSpies,this.NumberOfUsers)
    }

    override fun DisplayOneRole() {
        this.game.displayOneRole()
    }

    override fun EndGame() {
        this.game.endGame()
    }
}