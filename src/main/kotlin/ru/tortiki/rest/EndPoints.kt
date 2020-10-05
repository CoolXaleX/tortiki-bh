package ru.tortiki.rest

import org.bson.types.ObjectId
import ru.tortiki.entity.Post
import javax.ws.rs.*
import javax.ws.rs.core.MediaType


@Path("/hello")
class ExampleResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    fun hello() {
        Post("title", "desc", "01.01.2000", listOf()).persist()
    }
}

@Path("/post")
class PostEndPoint {

    @GET
    @Path("/all")
    @Produces(MediaType.TEXT_PLAIN)
    fun getAll(): List<Post> {
        return Post.listAll()
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.TEXT_PLAIN)
    fun findPostById(@PathParam("id") id: String): Post? {
        return Post.findById(ObjectId(id))
    }

    @POST
    @Path("/set")
    @Produces(MediaType.APPLICATION_JSON)
    fun setPost(post: Post): String {
        post.persist()
        return post.id.toString()
    }
}