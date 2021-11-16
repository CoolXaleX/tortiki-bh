package ru.tortiki.controller

import io.smallrye.mutiny.Uni
import ru.tortiki.service.UserService
import javax.inject.Inject
import javax.ws.rs.GET
import javax.ws.rs.Path
import javax.ws.rs.Produces
import javax.ws.rs.core.MediaType.APPLICATION_JSON

@Path("/user")
class UserController(@Inject val userService: UserService) {

    @GET
    @Produces(APPLICATION_JSON)
    fun getUser(): Uni<String> = userService.getUser("test")
}