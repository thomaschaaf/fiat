/*
 * Copyright 2015 Netflix, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.netflix.spinnaker.fiat.roles.github.client;

import com.netflix.spinnaker.fiat.roles.github.model.Member;
import com.netflix.spinnaker.fiat.roles.github.model.Team;
import java.util.List;
import retrofit.http.GET;
import retrofit.http.Path;
import retrofit.http.Query;

/** Retrofit interface for interacting with a GitHub REST API. */
public interface GitHubClient {

  @GET("/orgs/{org}/teams")
  List<Team> getOrgTeams(
      @Path("org") String org, @Query("page") int page, @Query("per_page") int paginationValue);

  @GET("/orgs/{org}/members")
  List<Member> getOrgMembers(
      @Path("org") String org, @Query("page") int page, @Query("per_page") int paginationValue);

  @GET("/orgs/{org}/teams/{idTeam}/members")
  List<Member> getMembersOfTeam(
      @Path("org") String org,
      @Path("idTeam") Long idTeam,
      @Query("page") int page,
      @Query("per_page") int paginationValue);
}
