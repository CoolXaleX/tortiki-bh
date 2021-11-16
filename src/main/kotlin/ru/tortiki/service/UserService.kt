package ru.tortiki.service

import io.smallrye.mutiny.Uni
import javax.enterprise.context.ApplicationScoped


interface UserService {
    fun getUser(s: String): Uni<String>
}

@ApplicationScoped
class UserServiceImpl : UserService {
    override fun getUser(s: String): Uni<String> = Uni.createFrom().item("Hello RESTEasy Reactive")
}

