package com.demo.example;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.example.service.UserService;


@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootFreemarkerApplicationTests {
	
	@Autowired
	RedisTemplate<String,String> redisTemplate;
	
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	
	@Autowired
	private UserService userService;
	
	@Test
	public void contextLoads() {
		System.out.println("=====");
		userService.register("张三", "127.0.0.1");
	}
	
	@Test
	public void test(){
		ValueOperations<String, String> opsForValue = redisTemplate.opsForValue();
		opsForValue.set("test3","my name ldf3");
		System.out.println("11"+opsForValue.get("test3"));
	}
	
	/*@Autowired
	private RoncooUserDao roncooUserDao;
	
	@Test
	public void insert() {
		RoncooUser roncooUser = new RoncooUser();
		roncooUser.setName("测试");
		roncooUser.setCreateTime(new Date());
		int result = roncooUserDao.insert(roncooUser);
		System.out.println(result);
	}

	@Test
	public void delete() {
		int result = roncooUserDao.deleteById(1);
		System.out.println(result);
	}

	@Test
	public void update() {
		RoncooUser roncooUser = new RoncooUser();
		roncooUser.setId(2);
		roncooUser.setName("测试2");
		roncooUser.setCreateTime(new Date());
		int result = roncooUserDao.updateById(roncooUser);
		System.out.println(result);
	}

	@Test
	public void select() {
		RoncooUser result = roncooUserDao.selectById(2);
		System.out.println(result);
	}

	// 分页测试
	@Test
	public void queryForPage() {
		Page<RoncooUser> result = roncooUserDao.queryForPage(1, 20, "测试");
		System.out.println(result.getList());
	}*/
/** JPA **/
/*	@Autowired
	private RoncooUserLogDao roncooUserLogDao;

	@Test
	public void insert() {
		RoncooUserLog entity = new RoncooUserLog();
		entity.setUserName("无境");
		entity.setUserIp("192.168.0.1");
		entity.setCreateTime(new Date());
		roncooUserLogDao.save(entity);
	}

	@Test
	public void delete() {
		roncooUserLogDao.delete(1);
	}

	@Test
	public void update() {
		RoncooUserLog entity = new RoncooUserLog();
		entity.setId(2);
		entity.setUserName("无境2");
		entity.setUserIp("192.168.0.1");
		entity.setCreateTime(new Date());
		roncooUserLogDao.save(entity);
	}

	@Test
	public void select() {
		RoncooUserLog result = roncooUserLogDao.findOne(2);
		System.out.println(result);
	}

	@Test
	public void select2() {
		RoncooUserLog result = roncooUserLogDao.findByUserName("无境2");
		System.out.println(result);
	}
	
	// 分页
		@Test
		public void queryForPage() {
			Pageable pageable = new PageRequest(0, 20, new Sort(new Order(Direction.DESC, "id")));
			//Page<RoncooUserLog> result = roncooUserLogDao.findByUserName("无境2", pageable);
			Page<RoncooUserLog> result = roncooUserLogDao.findAll(pageable);
			System.out.println(result.getContent());
		}*/
	
	
	//事物
	/*@Autowired
	private UserService userService;

	@Test
	public void register() {
		String result = userService.register("无境", "192.168.1.1");
		System.out.println(result);
	}*/
	
	//redis测试
	/*@Autowired
	private RoncooRedisComponent roncooRedisComponent;

	@Test
	public void set() {
		roncooRedisComponent.set("roncoo1", "hello world");
	}

	@Test
	public void get() {
		System.out.println(roncooRedisComponent.get("roncoo1"));
	}

	@Test
	public void del() {
		roncooRedisComponent.del("roncoo1");
	}*/
	//jms
	/*@Autowired
	private RoncooJmsComponent roncooJmsComponent;

	@Test
	public void send() {
		roncooJmsComponent.send("hello world");
	}*/
	
	/*@Autowired
	private RoncooAmqpComponent roncooAmqpComponent;

	@Test
	public void send() {
		roncooAmqpComponent.send("hello world2");
	}*/
	
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;

	/**
	 * get请求
	 */
	/*@Test
	public void getForObject() {

		RoncooUserLog bean = restTemplateBuilder.build().getForObject("http://localhost:8080/rest/update/{id}",
				RoncooUserLog.class, 1);
		System.out.println(bean);
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("id", 2);
		bean = restTemplateBuilder.build().postForObject("http://localhost:8080/rest/update", map, RoncooUserLog.class);
		System.out.println(bean);

		String result = restTemplateBuilder.additionalCustomizers(new ProxyCustomizer()).build()
				.getForObject("http://www.roncoo.com", String.class);
		System.out.println(result);

	}*/
	
	
	
	//代理测试
	
	/*static class ProxyCustomizer implements RestTemplateCustomizer {
		@Override
		public void customize(RestTemplate restTemplate) {
			String proxyHost = "118.144.149.206";
			int proxyPort = 3128;

			HttpHost proxy = new HttpHost(proxyHost, proxyPort);
			HttpClient httpClient = HttpClientBuilder.create().setRoutePlanner(new DefaultProxyRoutePlanner(proxy) {
				@Override
				public HttpHost determineProxy(HttpHost target, HttpRequest request, HttpContext context)
						throws HttpException {
					System.out.println("=="+target.getHostName());
					return super.determineProxy(target, request, context);
				}
			}).build();
			HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(
					httpClient);
			httpComponentsClientHttpRequestFactory.setConnectTimeout(10000);
			httpComponentsClientHttpRequestFactory.setReadTimeout(60000);
			restTemplate.setRequestFactory(httpComponentsClientHttpRequestFactory);
		}
	}*/
	
	
	
	
	
	
	
}
