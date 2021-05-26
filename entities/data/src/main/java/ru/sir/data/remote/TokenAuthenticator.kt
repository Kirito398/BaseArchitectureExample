package ru.sir.data.remote

import okhttp3.Authenticator
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route

class TokenAuthenticator(private val repository: AccessTokenRepository) : Authenticator {
    override fun authenticate(route: Route?, response: Response): Request? {
        val accessToken = repository.getAccessToken()
        //if (!isRequestWithAccessToken(response) || accessToken == "") return null

        synchronized(this) {
            val newAccessToken = repository.getAccessToken()
            if (accessToken != newAccessToken) return newRequest(response.request(), newAccessToken)

            val updatedAccessToken = repository.refreshAccessToken()
            if (updatedAccessToken == "") return null

            return newRequest(response.request(), updatedAccessToken)
        }
    }

    private fun isRequestWithAccessToken(response: Response): Boolean {
        val header = response.request().header("Authorization")
        return header != null && header.startsWith("Bearer")
    }

    private fun newRequest(request: Request, accessToken: String): Request =
        request.newBuilder()
            .header("Authorization", "Bearer $accessToken")
            .build()
}