# java-convenience-store-precourse

## 구현 기능 목록

### 입력 기능

- [ ] 구매할 상품과 수량을 입력 받는다. 상품명, 수량은 하이픈(-)으로, 개별 상품은 대괄호([])로 묶어 쉼표(,)로 구분한다.
- [ ] 프로모션 적용이 가능한 상품에 대해 고객이 해당 수량보다 적게 가져온 경우, 그 수량만큼 추가 여부를 입력받는다.
- [ ] 프로모션 재고가 부족하여 일부 수량을 프로모션 혜택 없이 결제해야 하는 경우, 일부 수량에 대해 정가로 결제할지 여부를 입력받는다.
- [ ] 멤버십 할인 적용 여부를 입력 받는다.
- [ ] 추가 구매 여부를 입력 받는다.

### 핵심 기능

재고 관리

- [x] 상품 목록과 행사 목록을 파일 입출력을 통해 불러온다.
- [ ] 각 상품의 재고 수량을 고려하여 결제 가능 여부를 확인한다.
- [ ] 고객이 상품을 구매할 때마다, 결제된 수량만큼 해당 상품의 재고에서 차감하여 수량을 관리한다.
- [ ] 재고를 차감함으로써 시스템은 최신 재고 상태를 유지하며, 다음 고객이 구매할 때 정확한 재고 정보를 제공한다.

프로모션 할인

- [ ] 오늘 날짜가 프로모션 기간 내에 포함된 경우에만 할인을 적용한다.
- [ ] 프로모션은 N개 구매 시 1개 무료 증정(Buy N Get 1 Free)의 형태로 진행된다.
- [ ] 1+1 또는 2+1 프로모션이 각각 지정된 상품에 적용되며, 동일 상품에 여러 프로모션이 적용되지 않는다.
- [ ] 프로모션 혜택은 프로모션 재고 내에서만 적용할 수 있다.
- [ ] 프로모션 기간 중이라면 프로모션 재고를 우선적으로 차감하며, 프로모션 재고가 부족할 경우에는 일반 재고를 사용한다.
- [ ] 프로모션 적용이 가능한 상품에 대해 고객이 해당 수량보다 적게 가져온 경우, 필요한 수량을 추가로 가져오면 혜택을 받을 수 있음을 안내한다.
- [ ] 프로모션 재고가 부족하여 일부 수량을 프로모션 혜택 없이 결제해야 하는 경우, 일부 수량에 대해 정가로 결제하게 됨을 안내한다.

멤버십 할인

- [ ] 멤버십 회원은 프로모션 미적용 금액의 30%를 할인받는다.
- [ ] 프로모션 적용 후 남은 금액에 대해 멤버십 할인을 적용한다.
- [ ] 멤버십 할인의 최대 한도는 8,000원이다.

### 출력 기능

- [ ] 환영 인사와 함께 상품명, 가격, 프로모션 이름, 재고를 안내한다. 만약 재고가 0개라면 재고 없음을 출력한다.
- [ ] 구매 상품 내역, 증정 상품 내역, 금액 정보를 영수증 형태로 출력한다.

### 예외 상황

상품과 수량 입력

- [ ] 존재하지 않는 상품을 입력할 경우
- [ ] 수량을 초과하여 입력할 경우
- [ ] 0개 이하의 수량을 입력할 경우
- [ ] 주어진 입력형식과 다르게 입력할 경우

Y/N 입력

- [ ] Y 또는 N 이외의 입력을 할 경우

파일 입출력

- [x] 존재하지 않는 파일인 경우

## 프로그램 흐름도

1. 보유하고 있는 상품을 출력한다.
2. 구매할 상품과 수량을 입력한다.
3. 오늘 날짜가 프로모션 기간 내에 포함된 경우 프로모션 혜택을 진행한다.
4. 구입한 만큼 재고를 감소한다.
4. 멤버십 할인 여부를 입력한다.
5. 영수증을 출력한다.
6. 추가 구매 여부를 입력한다.
