# 방송 편성표 만들기

프로젝트 설명과 실행 예시는 [노션](https://leedongyeop.notion.site/b13a3ef3ea9247b6b1ecab91e2b408be)에서 보시는 것을 추천드립니다.

작성 코드는 [Github](https://github.com/2dongyeop/toy-project-java/blob/main/src/BroadcastSchedule/Main.java)에서 보시는 것을 추천드립니다.

- 주제 : `방송 편성표`
- 설명
    - KBS, MBC, SBS 방송 편성표에 방송을 추가/출력/검색/수정/삭제를 할 수 있다.
    - 방송은 제목, 분야, 제작진, 방송하는 요일, 방송 시간으로 구성된다.

---

<br/>

### 보완할 점

> 현재 방송국별 편성표가 아닌, 통합 편성표로 작성을 하였습니다. 

`programs` 가 아닌 `kbs-programs`, `mbc-programs`, `sbs-programs` 로 관리할 수 있지만,
보기 좋은 깔끔한 코드를 위해 통합 편성표로 작성하였습니다.
