package bridge.domain.view;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */

import bridge.constants.GuideSentences;
import bridge.constants.Direction;
import bridge.domain.model.CrossRecord;
import bridge.domain.model.GameResultInformation;
import java.util.Map;

/**
 * 패키지 변경 가능
 * 메소드 인자와 반환 타입 추가 혹은 변경 가능
 * 값 출력을 위해 필요한 메소드 추가 가능
 *
 * 메소드 이름 변경 불가능
 */
public class OutputView {

    public void printEmptyLine() {
        System.out.print("\n");
    }

    public void printStartGuide() {
        System.out.println(GuideSentences.START.getSentence());
        printEmptyLine();
    }

    public void printInputBridgeLengthGuide() {
        System.out.println(GuideSentences.INPUT_BRIDGE_LENGTH.getSentence());
    }

    public void printInputMoveDirectionGuide() {
        System.out.println(GuideSentences.INPUT_MOVING_DIRECTION.getSentence());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
        Map<Direction, String> crossRecord = CrossRecord.getCrossedBridge();
        for (Direction BRIDGE_DIRECTION : Direction.values()) {
            String oneDirectionRecord = crossRecord.get(BRIDGE_DIRECTION);
            System.out.println(oneDirectionRecord);
        }
        printEmptyLine();
    }

    public void printRetryGuide() {
        System.out.println(GuideSentences.INPUT_RETRY.getSentence());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
        System.out.println(GuideSentences.RESULT.getSentence());
        printMap();
        System.out.println(
                GuideSentences.IS_SUCCESS.getSentence() + GameResultInformation.getGameResult()
                        .getResult());
        System.out.println(GuideSentences.COUNT_OF_TRY.getSentence() + GameResultInformation.getCountOfTry());
    }
}
