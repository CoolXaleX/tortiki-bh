package ru.tortiki.rest

import ru.tortiki.entity.Filter
import ru.tortiki.entity.Post
import ru.tortiki.service.PostService
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/post")
class PostEndPoint {

    @Inject
    @field: Default
    lateinit var postService: PostService

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    fun getAll(): Response {
        return Response.ok(postService.getPosts(1,1)).build()
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun findPostById(@PathParam("id") id: String): Response {
        return Response.ok(postService.getPost(id)).build()
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun addPost(post: Post?): Response {
        println("add $post")
        return Response.ok(postService.addPost(post)).build()
    }

    @POST
    @Path("/list")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun getList(filter: Filter): Response {
        println("list $filter")
        return Response.ok(postService.search(filter)).build()
    }
}