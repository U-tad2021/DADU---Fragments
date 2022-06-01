package com.amarinag.dadu_fragments.user


import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("login")
    @Expose
    val login: String?, // mojombo
    @SerializedName("id")
    @Expose
    val id: Int?, // 1
    @SerializedName("node_id")
    @Expose
    val nodeId: String?, // MDQ6VXNlcjE=
    @SerializedName("avatar_url")
    @Expose
    val avatarUrl: String?, // https://avatars.githubusercontent.com/u/1?v=4
    @SerializedName("gravatar_id")
    @Expose
    val gravatarId: String?,
    @SerializedName("url")
    @Expose
    val url: String?, // https://api.github.com/users/mojombo
    @SerializedName("html_url")
    @Expose
    val htmlUrl: String?, // https://github.com/mojombo
    @SerializedName("followers_url")
    @Expose
    val followersUrl: String?, // https://api.github.com/users/mojombo/followers
    @SerializedName("following_url")
    @Expose
    val followingUrl: String?, // https://api.github.com/users/mojombo/following{/other_user}
    @SerializedName("gists_url")
    @Expose
    val gistsUrl: String?, // https://api.github.com/users/mojombo/gists{/gist_id}
    @SerializedName("starred_url")
    @Expose
    val starredUrl: String?, // https://api.github.com/users/mojombo/starred{/owner}{/repo}
    @SerializedName("subscriptions_url")
    @Expose
    val subscriptionsUrl: String?, // https://api.github.com/users/mojombo/subscriptions
    @SerializedName("organizations_url")
    @Expose
    val organizationsUrl: String?, // https://api.github.com/users/mojombo/orgs
    @SerializedName("repos_url")
    @Expose
    val reposUrl: String?, // https://api.github.com/users/mojombo/repos
    @SerializedName("events_url")
    @Expose
    val eventsUrl: String?, // https://api.github.com/users/mojombo/events{/privacy}
    @SerializedName("received_events_url")
    @Expose
    val receivedEventsUrl: String?, // https://api.github.com/users/mojombo/received_events
    @SerializedName("type")
    @Expose
    val type: String?, // User
    @SerializedName("site_admin")
    @Expose
    val siteAdmin: Boolean?, // false
    @SerializedName("name")
    @Expose
    val name: String?, // Tom Preston-Werner
    @SerializedName("company")
    @Expose
    val company: String?, // @chatterbugapp, @redwoodjs, @preston-werner-ventures 
    @SerializedName("blog")
    @Expose
    val blog: String?, // http://tom.preston-werner.com
    @SerializedName("location")
    @Expose
    val location: String?, // San Francisco
    @SerializedName("email")
    @Expose
    val email: Any?, // null
    @SerializedName("hireable")
    @Expose
    val hireable: Any?, // null
    @SerializedName("bio")
    @Expose
    val bio: Any?, // null
    @SerializedName("twitter_username")
    @Expose
    val twitterUsername: String?, // mojombo
    @SerializedName("public_repos")
    @Expose
    val publicRepos: Int?, // 64
    @SerializedName("public_gists")
    @Expose
    val publicGists: Int?, // 62
    @SerializedName("followers")
    @Expose
    val followers: Int?, // 22995
    @SerializedName("following")
    @Expose
    val following: Int?, // 11
    @SerializedName("created_at")
    @Expose
    val createdAt: String?, // 2007-10-20T05:24:19Z
    @SerializedName("updated_at")
    @Expose
    val updatedAt: String? // 2022-05-21T16:26:24Z
)