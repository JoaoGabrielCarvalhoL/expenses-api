package br.com.carv.expenses.mapper;

import br.com.carv.expenses.model.User;
import br.com.carv.expenses.model.dto.request.UserPostRequest;
import br.com.carv.expenses.model.dto.request.UserPutRequest;
import br.com.carv.expenses.model.dto.response.UserGetResponse;
import br.com.carv.expenses.model.dto.response.UserSimpleResponse;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserGetResponse toUserGetResponse(User user);

    User toUser(UserPostRequest userPostRequest);

    User toUser(UserPutRequest userPutRequest);

    UserSimpleResponse toUserSimpleResponse(User user);
}
