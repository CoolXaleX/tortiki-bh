package ru.tortiki.service

import io.quarkus.mongodb.panache.PanacheQuery
import io.quarkus.panache.common.Page
import org.bson.types.ObjectId
import ru.tortiki.entity.Filter
import ru.tortiki.entity.Post
import javax.enterprise.context.ApplicationScoped

@ApplicationScoped
class MongoPostService : PostService {
    override fun addPost(post: Post): String? {
        post.persist()
        return post.id.toString()
    }

    override fun getPost(id: String): Post = Post.findById(ObjectId(id))

    override fun search(filter: Filter): List<Post> {
        val postQuery: PanacheQuery<Post> = createQuery(filter)
        if (filter.count > 0) {
            postQuery.page<Post>(Page.ofSize(filter.count))
            if (filter.page >= 0) postQuery.page<Post>(filter.page, filter.count)
        }
        return postQuery.list()
    }

    private fun createQuery(filter: Filter): PanacheQuery<Post> {
        return if (filter.ids.isEmpty()) Post.findAll()
        else Post.find<Post>("_id in ?1", filter.ids.map { s -> ObjectId(s) })
    }
}