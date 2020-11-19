package ru.tortiki.rest

import org.jboss.logging.Logger
import ru.tortiki.entity.Filter
import ru.tortiki.entity.Like
import ru.tortiki.entity.Post
import ru.tortiki.service.PostService
import javax.enterprise.inject.Default
import javax.inject.Inject
import javax.ws.rs.*
import javax.ws.rs.core.MediaType
import javax.ws.rs.core.Response

@Path("/post")
class PostEndPoint {
    private val log: Logger = Logger.getLogger(PostEndPoint::class.java)

    @Inject
    @field: Default
    lateinit var postService: PostService

    @GET
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    fun getAll(): Response {
        log.info("Get all posts")
        return Response.ok(postService.search(Filter())).build()
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    fun findPostById(@PathParam("id") id: String): Response {
        log.info("Get $id post")
        return Response.ok(postService.getPost(id)).build()
    }

    @POST
    @Path("/add")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun addPost(post: Post): Response {
        log.info("Add $post")
        return Response.ok(postService.addPost(post)).build()
    }

    @POST
    @Path("/getList")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun getList(filter: Filter): Response {
        log.info("Get list for $filter")
        return Response.ok(postService.search(filter)).build()
    }

    @POST
    @Path("/like")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    fun like(like: Like): Response {
        log.info("Set like $like")
        return Response.ok(postService.setLike(like)).build()
    }
}