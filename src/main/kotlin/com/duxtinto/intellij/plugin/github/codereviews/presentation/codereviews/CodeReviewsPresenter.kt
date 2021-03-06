package com.duxtinto.intellij.plugin.github.codereviews.presentation.codereviews

import com.duxtinto.intellij.plugin.github.codereviews.domain.pullrequests.PullRequestEntity
import com.duxtinto.intellij.plugin.github.codereviews.domain.pullrequests.reviews.CodeReviewEntity
import com.duxtinto.intellij.plugin.github.codereviews.domain.pullrequests.reviews.comments.CodeReviewCommentEntity
import javax.inject.Inject

class CodeReviewsPresenter
    @Inject
    constructor()
    : CodeReviews.Presenter {
    private var model: CodeReviews.Model = CodeReviewsModel()

    private var view : CodeReviews.View? = null
    override fun setView(view: CodeReviews.View) {
        this.view = view
    }

    override fun presentPullRequest(pullRequest: PullRequestEntity) {
        model.setPullRequest(pullRequest)
        view?.render(model)
    }

    override fun presentReviews(reviews: List<CodeReviewEntity>) {
        model.setReviews(reviews)
        view?.render(model)
    }

    override fun presentComments(review: CodeReviewEntity, comments: List<CodeReviewCommentEntity>) {
        model.setReviewComments(review, comments)
        view?.render(model)
    }

    override fun clear() {
        model.setPullRequest(null)
    }
}