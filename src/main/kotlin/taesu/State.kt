package taesu

// 예제에서 State 를 따로 정의하지 않은 이유는 List<??>로 관리되면서 다형성이 사용되는게 아니기 때문에 생략한 것을 보임.

sealed class AuthorizationState {

    //    Concreate State
    class Unauthorized : AuthorizationState()

    //    Concreate State
    class Authorized(val userName: String) : AuthorizationState()
}

// Context
class AuthorizationPresenter {

    private var state: AuthorizationState = AuthorizationState.Unauthorized()

    fun loginUser(userLogin: String) {
        state = AuthorizationState.Authorized(userLogin)
    }

    fun logoutUser() {
        state = AuthorizationState.Unauthorized()
    }

    val isAuthorized: Boolean
        get() {
            when (state) {
                is AuthorizationState.Authorized -> return true
                else -> return false
            }
        }

    val userLogin: String
        get() {
            when (state) {
                is AuthorizationState.Authorized -> return (state as AuthorizationState.Authorized).userName
                is AuthorizationState.Unauthorized -> return "Unknown"
            }
        }

    override fun toString(): String {
        return "User '$userLogin' is logged in: $isAuthorized"
    }
}

fun main(args: Array<String>) {
    val authorization = AuthorizationPresenter()
    authorization.loginUser("admin")
    println(authorization)
    authorization.logoutUser()
    println(authorization)
}