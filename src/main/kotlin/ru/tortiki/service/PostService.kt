package ru.tortiki.service

import ru.tortiki.entity.Filter
import ru.tortiki.entity.Post

interface PostService {
    fun addPost(post:Post?) : String?
    fun getPosts(from:Int, to: Int) : List<Post>
    fun getPost(id: String) : Post
    fun search(filter: Filter)
}