package id.gate.root.gaterootbe.mapper;

public interface BaseMapper<SOURCE,TARGET> {
    SOURCE reverse (TARGET target);
//    TARGET convert (SOURCE source);
}
