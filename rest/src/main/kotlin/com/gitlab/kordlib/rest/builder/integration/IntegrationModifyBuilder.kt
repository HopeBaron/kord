package com.gitlab.kordlib.rest.builder.integration

import com.gitlab.kordlib.rest.builder.RequestBuilder
import com.gitlab.kordlib.rest.json.request.GuildIntegrationModifyRequest
import com.gitlab.kordlib.rest.json.response.IntegrationExpireBehavior

/**
 * Builder for [modifying an integration](https://discordapp.com/developers/docs/resources/guild#modify-guild-integration).
 */
class IntegrationModifyBuilder : RequestBuilder<GuildIntegrationModifyRequest> {

    /**
     * the behavior when an integration subscription lapses.
     */
    var expireBehavior: IntegrationExpireBehavior? = null

    /**
     * 	Period in days where the integration will ignore lapsed subscriptions
     */
    var expirePeriodInDays: Int? = null

    /**
     * whether emoticons should be synced for this integration (twitch only currently).
     */
    var enableEmoticons: Boolean? = null

    override fun toRequest(): GuildIntegrationModifyRequest = GuildIntegrationModifyRequest(
            expireBehavior?.code, expirePeriodInDays, enableEmoticons
    )

}