package com.example.rest_api;

import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.GreaterOrEqual;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class RestApiApplicationTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getUserByName() throws Exception{
		String Name = "Ohtani";

		ResultActions result = mockMvc.perform(get("/api/v2/player?name={Name}",Name));

		result.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[0].name").value(containsString("Ohtani")));
	}

	@Test
	public void getUserByPosition() throws Exception{
		String position = "SS";

		ResultActions result = mockMvc.perform(get("/api/v2/player?position={position}",position));

		result.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[*].position").value(hasItem(position)));
	}

	@Test
	public void getUserByTeam() throws Exception{
		String team = "LAD";

		ResultActions result = mockMvc.perform(get("/api/v2/player?team={team}",team));

		result.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[*].team").value(hasItem(team)));
	}
	@Test
	public void getUserByHomerunmore() throws Exception{
		Integer hr = 30;

		ResultActions result = mockMvc.perform(get("/api/v2/player?homerunmore={hr}",hr));

		result.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[*].homerun",everyItem(greaterThanOrEqualTo(hr))));
	}

	@Test
	public void getUserByHomerunless() throws Exception{
		Integer hr = 30;

		ResultActions result = mockMvc.perform(get("/api/v2/player?homerunless={hr}",hr));

		result.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[*].homerun",everyItem(lessThanOrEqualTo(hr))));
	}

	@Test
	public void getUserByHitless() throws Exception{
		Integer hit = 100;

		ResultActions result = mockMvc.perform(get("/api/v2/player?homerunless={hit}",hit));

		result.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[*].hitless",everyItem(lessThanOrEqualTo(hit))));
	}

	@Test
	public void getUserByHitmore() throws Exception{
		Integer hit = 30;

		ResultActions result = mockMvc.perform(get("/api/v2/player?homerunless={hit}",hit));

		result.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$[*].hitmore",everyItem(lessThanOrEqualTo(hit))));
	}





}
