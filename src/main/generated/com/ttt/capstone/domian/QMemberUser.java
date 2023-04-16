package com.ttt.capstone.domian;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMemberUser is a Querydsl query type for MemberUser
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMemberUser extends EntityPathBase<MemberUser> {

    private static final long serialVersionUID = -65955093L;

    public static final QMemberUser memberUser = new QMemberUser("memberUser");

    public final DateTimePath<java.time.LocalDateTime> createdAt = createDateTime("createdAt", java.time.LocalDateTime.class);

    public final StringPath email = createString("email");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath name = createString("name");

    public final StringPath password = createString("password");

    public QMemberUser(String variable) {
        super(MemberUser.class, forVariable(variable));
    }

    public QMemberUser(Path<? extends MemberUser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMemberUser(PathMetadata metadata) {
        super(MemberUser.class, metadata);
    }

}

