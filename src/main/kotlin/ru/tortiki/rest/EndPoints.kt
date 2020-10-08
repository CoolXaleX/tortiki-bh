package ru.tortiki.rest

import org.bson.types.ObjectId
import ru.tortiki.entity.Post
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response


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
    @Produces(MediaType.APPLICATION_JSON)
    fun getAll(): Response {
        return Response.ok(Post.listAll<Post>()).build()
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun findPostById(@PathParam("id") id: String): Response {
        return Response.ok(Post.findById(ObjectId(id))).build()
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun addPost(post: Post): Response {
        post.persist()
        return Response.ok(post.id.toString()).build()
    }
}