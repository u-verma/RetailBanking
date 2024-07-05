package banking.api.user.controller

import banking.api.user.controller.UserProfileResource.Companion.USER_PROFILE_ENDPOINT
import banking.api.user.domain.UpdateUserProfileRequest
import banking.api.user.domain.UserProfileRequest
import banking.api.user.domain.UserProfileResponse
import jakarta.websocket.server.PathParam
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus

@RequestMapping(USER_PROFILE_ENDPOINT)
@CrossOrigin(origins = ["http://localhost:5173"])
interface UserProfileResource {

    companion object {
        const val USER_PROFILE_ENDPOINT = "/api/v1/user-profile"
    }

    @PostMapping("/create")
    @ResponseStatus(OK)
    @ResponseBody
    fun createUserProfile(@RequestBody request: UserProfileRequest): UserProfileResponse

    @GetMapping("/{id}")
    @ResponseStatus(OK)
    @ResponseBody
    fun getUserProfileById(@PathVariable("id") id: String): UserProfileResponse

    @GetMapping("/email/{email}")
    @ResponseStatus(OK)
    @ResponseBody
    fun getUserProfileByEmail(@PathVariable email: String): UserProfileResponse

    @GetMapping
    @ResponseStatus(OK)
    @ResponseBody
    fun getAllUserProfiles(): List<UserProfileResponse>

    @PutMapping("/{id}")
    @ResponseStatus(OK)
    @ResponseBody
    fun updateUserProfile(@PathVariable("id") id: String, @RequestBody request: UpdateUserProfileRequest): UserProfileResponse
}