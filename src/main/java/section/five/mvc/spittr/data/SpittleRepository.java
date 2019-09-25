package section.five.mvc.spittr.data;

import section.five.mvc.spittr.Spittle;

import java.util.List;

public interface SpittleRepository {
    List<Spittle> findSpittles(long max, int count);
}
