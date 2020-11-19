package ru.tortiki.service

import org.bson.types.ObjectId
import ru.tortiki.entity.Filter
import ru.tortiki.entity.Post
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class MongoPostService : PostService {
    override fun addPost(post: Post?): String? {
        post?.persist()
        return post?.id.toString()
    }

    override fun getPosts(from: Int, to: Int): List<Post> = Post.listAll()

    override fun getPost(id: String): Post = Post.findById(ObjectId(id))

    override fun search(filter: Filter) {
        TODO("Not yet implemented")
        Post.find<Post>("{ _id : { \$in : ?1 } }", filter.ids.toString()).list<Post>()
    }
}