package ru.tortiki.service

import ru.tortiki.entity.Filter
import ru.tortiki.entity.Like
import ru.tortiki.entity.Post
import ru.tortiki.entity.User

interface PostService {
    fun addPost(post: Post): String?
    fun getPost(id: String): Post
    fun search(filter: Filter): List<Post>
    fun setLike(like: Like): Boolean
}

interface UserService {
    fun addUser(user: User): Boolean
    fun getUser(id: String): User
}