package io.zerogone.service;

import io.zerogone.domain.Member;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:appConfig.xml")
@Transactional
public class MemberServiceTest extends TestCase {
    @Autowired
    MemberService service;

    @Test
    public void testJoin() {
        Member member = new Member();
        member.setName("김영곤");

        Long saveId = service.join(member);

        assertEquals(member, service.findOne(saveId));
    }
}