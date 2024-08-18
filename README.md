
# 프로젝트 설명
NameLove는 Android Clean Architecture를 구현하기 위한 토이 프로젝트로, 이름을 통해 두사람의 궁합의 점수를 보여주는 간단한 애플리케이션입니다. 
NameLove는 두 개의 이름을 입력받아 Rapid API를 사용하여 궁합 점수를 나타냅니다.

이 프로젝트는 최신 Android 개발 기법과 도구들을 학습하고 활용하는 데 중점을 두고 있습니다.

# 주요 기능
이름 의미 분석: 입력된 두 개의 이름에 대해 의미를 분석하고 표시합니다.
매력도 평가: 이름의 의미를 바탕으로 각 이름의 매력도를 점수화하여 비교합니다.
의존성 관리: build-logic과 version-catalog를 이용하여 프로젝트 의존성을 효율적으로 관리합니다.


# 기술 스택
이 프로젝트에서는 최신 Android 개발 기술을 사용하여 Clean Architecture를 구현했습니다. 다음은 프로젝트에서 사용된 주요 기술 스택입니다:

1. Kotlin: Android 애플리케이션 개발을 위한 주요 프로그래밍 언어.
2. Multi-Module Architecture: 앱의 기능을 모듈 단위로 분리하여 독립적인 개발 및 테스트가 가능하도록 설계.
3. MVVM (Model-View-ViewModel): UI와 비즈니스 로직을 분리하여 유지보수성과 테스트 용이성을 향상.
4. Navigation Component: 애플리케이션 내에서 화면 간의 네비게이션을 쉽게 구현.
5. Hilt: 의존성 주입(DI)을 위한 Android 공식 라이브러리로, 코드의 결합도를 낮추고 테스트 용이성을 높임.


# 프로젝트 구조
프로젝트는 Multi-Module 구조로 구성되어 있으며, 각 모듈은 독립적으로 동작하며 명확한 책임을 가집니다. 주요 모듈은 다음과 같습니다:
1. app: 앱의 진입점으로, UI와 앱의 전반적인 구성 요소를 포함.
2. core: data/domain을 포함한 Core 모듈. 
   - data: 데이터 소스(네트워크, 로컬 데이터베이스 등)와 관련된 모든 로직을 포함.
   - domain: repository의 interface와 usecase/ui model 정의
   - database: Room을 이용한 데이터 저장
   - datastore: DB외의 데이터를 저장하기위한 datastore 모듈
   - network: Retrofit을 이용한 Api 명시와 구현
   - common: 모듈에서 사용되는 공통 유틸리티, 확장 함수, 상수 등을 포함.
   - ui: feature에서 사용되는 공통 UI 구현
4. feature: navigation 정의와 Composable UI 및 ViewModel.

# 의존성 관리
프로젝트에서 사용하는 모든 라이브러리와 플러그인은 build-logic 및 version-catalog를 통해 중앙에서 관리됩니다. 이를 통해 프로젝트의 일관성을 유지하고, 의존성 업데이트를 쉽게 관리할 수 있습니다.
