package com.example.starwars.auth

import javax.inject.Qualifier


@Qualifier
@Retention(AnnotationRetention.SOURCE)
annotation class ApplicationContext

@Qualifier
@Retention(AnnotationRetention.SOURCE)
annotation class BaseUrl